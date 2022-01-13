package text;

import java.io.File;

import javax.sound.sampled.UnsupportedAudioFileException;

public class Wtest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//String s = "2three45sixseven";		
		WaveToRaw wtr = new WaveToRaw();
		
		try {
			String d="D:\\WAV\\SY2619058701_001_20181126_0010F26_0010P26_VS-REC1$.wav"; //변환할파일 경로+파일명
			String s = "D:\\WAV\\change2.wav"; //저장될 파일 경로+파일명
			wtr.SaveRaw(d, s);			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
