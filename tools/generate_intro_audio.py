import numpy as np,wave,subprocess,json
from pathlib import Path
root=Path(__file__).resolve().parents[1]/'src/main/resources/assets/timelocked'
(root/'sounds/intro').mkdir(parents=True,exist_ok=True)
r=np.random.default_rng(88916);sr=24000
for name,dur in [('tv',10),('rain',10),('transition',8),('surf',12)]:
 t=np.arange(int(sr*dur))/sr;noise=r.normal(0,1,len(t));smooth=np.convolve(noise,np.ones(30)/30,mode='same')
 if name=='tv':a=.045*smooth+.008*np.sin(2*np.pi*110*t)*(1+.3*np.sin(t*1.7))
 elif name=='rain':a=.065*noise+.14*smooth
 elif name=='surf':a=(.13+.1*np.sin(t*.65-.8))*(smooth*.9+noise*.14)
 else:a=.07*np.sin(2*np.pi*1050*t)*np.exp(-t*.65)+(.015+.07*np.clip((t-2)/5,0,1))*(smooth+noise*.15)
 a*=np.minimum(1,t/.3)*np.minimum(1,(dur-t)/.6)
 path=root/'sounds/intro'/(name+'.wav')
 with wave.open(str(path),'wb') as w:w.setnchannels(1);w.setsampwidth(2);w.setframerate(sr);w.writeframes((np.clip(a,-.8,.8)*32767).astype('<i2').tobytes())
 subprocess.run(['ffmpeg','-v','error','-y','-i',str(path),'-c:a','libvorbis','-q:a','3',str(root/'sounds/intro'/(name+'.ogg'))],check=True)
 path.unlink()
p=root/'sounds.json';d=json.load(open(p))
for n in ['tv','rain','transition','surf']:d['intro_'+n]={'sounds':[{'name':'timelocked:intro/'+n,'stream':False}], 'subtitle':'subtitles.timelocked.intro_'+n}
p.write_text(json.dumps(d,indent=2)+'\n')
p=root/'lang/en_us.json';d=json.load(open(p));d.update({'subtitles.timelocked.intro_'+n:s for n,s in [('tv','Television hums'),('rain','Rain against the windows'),('transition','Ringing fades into waves'),('surf','Waves wash ashore')]});p.write_text(json.dumps(d,indent=2,ensure_ascii=False)+'\n')
