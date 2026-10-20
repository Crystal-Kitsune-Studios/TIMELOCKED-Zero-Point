"""Create a PA startup mix. Requires FFmpeg on PATH; never needed for a normal build."""

import argparse
import subprocess
from pathlib import Path

# Seconds, Hz and gains in this graph are sound-design parameters, not game timings.
# Retain the original filter exactly so the portable wrapper does not change the mix.
FILTER = "[0:a]aformat=channel_layouts=mono,highpass=f=240,lowpass=f=4200,equalizer=f=1700:t=q:w=0.8:g=4,acompressor=threshold=0.1:ratio=3.2:attack=8:release=100:makeup=1.4,volume=1.35,asoftclip=type=atan:threshold=0.85,aecho=0.8:0.9:63|127|219:0.20|0.11|0.055,loudnorm=I=-18:TP=-2:LRA=8,aresample=48000,asplit=2[full][cold];[full]volume='min(t/3.2,1)':eval=frame[steady];[cold]highpass=f=480,lowpass=f=950,vibrato=f=4:d=0.18,tremolo=f=11:d=0.5,volume='(1-min(t/3.2,1))*(0.18+0.82*min(t/2,1))':eval=frame[start];anoisesrc=color=pink:sample_rate=48000:duration=3.2:amplitude=0.013,highpass=f=1000,lowpass=f=6000,tremolo=f=27:d=0.9,afade=t=out:st=0:d=3.2[hiss];[steady][start][hiss]amix=inputs=3:normalize=0:duration=longest,alimiter=limit=0.86:level=0[a]"


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("input", type=Path, help="Original NAU_Anthem.mp3")
    parser.add_argument(
        "output",
        type=Path,
        nargs="?",
        default=Path(__file__).resolve().parents[1] / "build/audio",
    )
    args = parser.parse_args()
    if not args.input.is_file():
        parser.error("Input audio file does not exist")
    args.output.mkdir(parents=True, exist_ok=True)
    ogg = args.output / "nau_anthem_pa_startup.ogg"
    try:
        subprocess.run(
            [
                "ffmpeg",
                "-hide_banner",
                "-y",
                "-i",
                str(args.input),
                "-filter_complex",
                FILTER,
                "-map",
                "[a]",
                "-ac",
                "1",
                "-ar",
                "48000",
                "-c:a",
                "libvorbis",
                "-q:a",
                "5",
                str(ogg),
            ],
            check=True,
        )
        subprocess.run(
            [
                "ffmpeg",
                "-hide_banner",
                "-y",
                "-i",
                str(ogg),
                "-c:a",
                "libmp3lame",
                "-b:a",
                "160k",
                "-metadata",
                "title=NAU Anthem — PA startup mix",
                str(args.output / "NAU_Anthem_PA_Startup.mp3"),
            ],
            check=True,
        )
    except FileNotFoundError:
        parser.exit(1, "FFmpeg is required on PATH.\n")


if __name__ == "__main__":
    main()
