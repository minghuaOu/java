import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	Clip AudioClip;

	public Audio(String str) {//音频构造器
		try {
			if (str == "start") {
				File startFile = new File("src/audio/start.wav");//接收一个文件流
				AudioInputStream startFileStream = AudioSystem
						.getAudioInputStream(startFile);//转化为一个音频流
				AudioClip = AudioSystem.getClip();//获得一个剪辑对象
				AudioClip.open(startFileStream);//输入相应的句柄
				AudioClip.start();//播放剪辑
			}
			if (str == "hit") {
				File hitFile = new File("src/audio/hit.wav");
				AudioInputStream hitFileStream = AudioSystem
						.getAudioInputStream(hitFile);
				AudioClip = AudioSystem.getClip();
				AudioClip.open(hitFileStream);
				AudioClip.start();
			}
			if (str == "fire") {
				File fireFile = new File("src/audio/fire.wav");
				AudioInputStream fireFileStream = AudioSystem
						.getAudioInputStream(fireFile);
				AudioClip = AudioSystem.getClip();
				AudioClip.open(fireFileStream);
				AudioClip.start();
			}
			if (str == "blast") {
				File blastFile = new File("src/audio/blast.wav");
				AudioInputStream blastFileStream = AudioSystem
						.getAudioInputStream(blastFile);
				AudioClip = AudioSystem.getClip();
				AudioClip.open(blastFileStream);
				AudioClip.start();
			}
			if (str == "win") {
				File winFile = new File("src/audio/win.wav");
				AudioInputStream winFileStream = AudioSystem
						.getAudioInputStream(winFile);
				AudioClip = AudioSystem.getClip();
				AudioClip.open(winFileStream);
				AudioClip.start();
			}
			if (str == "die") {
				File dieFile = new File("src/audio/die.wav");
				AudioInputStream dieFileStream = AudioSystem
						.getAudioInputStream(dieFile);
				AudioClip = AudioSystem.getClip();
				AudioClip.open(dieFileStream);
				AudioClip.start();
			}
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (LineUnavailableException e3) {
			e3.printStackTrace();
		}
	}

}
