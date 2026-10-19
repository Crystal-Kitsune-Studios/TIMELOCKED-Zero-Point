#!/usr/bin/env bash
set -euo pipefail
INPUT="${1:?Supply the original NAU_Anthem.mp3 path}"
OUT="${2:-design/08912}"
mkdir -p "$OUT"
# Mono, band-limited, compressed, lightly saturated and short facility echoes.
PA="aformat=channel_layouts=mono,highpass=f=240,lowpass=f=4200,equalizer=f=1700:t=q:w=0.8:g=4,acompressor=threshold=0.1:ratio=3.2:attack=8:release=100:makeup=1.4,volume=1.35,asoftclip=type=atan:threshold=0.85,aecho=0.8:0.9:63|127|219:0.20|0.11|0.055,loudnorm=I=-18:TP=-2:LRA=8"
# First 3.2s: restricted bandwidth, gain ramp, mild flutter and fading circuit hiss.
FILTER="[0:a]${PA},aresample=48000,asplit=2[full][cold];[full]volume='min(t/3.2,1)':eval=frame[steady];[cold]highpass=f=480,lowpass=f=950,vibrato=f=4:d=0.18,tremolo=f=11:d=0.5,volume='(1-min(t/3.2,1))*(0.18+0.82*min(t/2,1))':eval=frame[start];anoisesrc=color=pink:sample_rate=48000:duration=3.2:amplitude=0.013,highpass=f=1000,lowpass=f=6000,tremolo=f=27:d=0.9,afade=t=out:st=0:d=3.2[hiss];[steady][start][hiss]amix=inputs=3:normalize=0:duration=longest,alimiter=limit=0.86:level=0[a]"
ffmpeg -hide_banner -y -i "$INPUT" -filter_complex "$FILTER" -map '[a]' -ac 1 -ar 48000 -c:a libvorbis -q:a 5 "$OUT/nau_anthem_pa_startup.ogg"
ffmpeg -hide_banner -y -i "$OUT/nau_anthem_pa_startup.ogg" -c:a libmp3lame -b:a 160k -metadata title='NAU Anthem — PA startup mix' "$OUT/NAU_Anthem_PA_Startup.mp3"
