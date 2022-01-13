package text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;

public class WaveToRaw {
	private FileInputStream fstream = null;
	private byte[] audioBytes = new byte[1024];
	private byte[] buff = new byte[1024];
	private int read;
	
	
	public WaveToRaw() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 리니어 PCM 인코딩 및 지정된 파라미터를 가지는 AudioFormat를 구축합니다.
	// http://cris.joongbu.ac.kr/course/java/api/javax/sound/sampled/AudioFormat.html
	private static final AudioFormat FORMAT = new AudioFormat(
		//16_000, // 16 kHz, sampleRate
		8_000, // 8 kHz, sampleRate
		16, // 16 bits, sampleSizeInBits
		1, // Mono, int channels
		true, // Signed
		false // Little endian, True is BigEndian
	);

	//바이트 배열을 Raw 파일로 저장
	//Save byte array as Raw file
	public void SaveRaw(String data, String s) throws Exception {
		File file = new File(data);
		
		String osName = System.getProperty("os.name");  
		if(osName.indexOf("Linux")>-1) {
			
		}else if(osName.indexOf("Windows")>-1){
			String cmd = "ffmpeg -i "+data+" -ac 1 -ar 8k -sample_fmt s16 "+s; 
			try {
				/*
				String pPath = "D:\\app\\";//ffmpeg 프로그램 경로
				FFmpeg ffmpeg = new FFmpeg(pPath+"ffmpeg");
				FFprobe ffprobe = new FFprobe(pPath+"ffprobe");
				*/
				File outFile = new File(s);
				List<String> commands = new ArrayList<String>();
				commands.add("d:\\app\\ffmpeg");
				commands.add("-i");
				commands.add(data);
				commands.add("-ac");
				commands.add("-1");
				commands.add("-ar");
				commands.add("8k");
				commands.add("-sample_fmt");
				commands.add("s16");
				commands.add(s);
				
				ProcessBuilder pb = new ProcessBuilder();
				pb.redirectErrorStream(true);
				pb.command(commands);
				Process p = pb.start();
				exhaustInputStream(p.getInputStream());
		           

	            // p의 자식 프로세스의 작업(동영상 등 변환 작업)이 완료될 동안 p를 대기시킴
	            int exitValue;
				try {
					exitValue = p.waitFor();	 

	     
		            if (exitValue == 0) {
		                if (outFile.length() == 0) {
		                    throw new Exception("* 변환된 파일의 사이즈가 0임!");
		                }
		            }
		            else {
		                throw new Exception("* 변환 중 에러 발생(Probably FFMPEG option error)!");
		            }
	            
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				/*
				Process process = Runtime.getRuntime().exec("cmd /c " + cmd);
				BufferedReader reader = new BufferedReader(
				        new InputStreamReader(process.getInputStream()));
				String line = null;
				StringBuffer sb = new StringBuffer();
				sb.append(cmd);
				while ((line = reader.readLine()) != null) {
				    sb.append(line);
				    sb.append("\n");
				}
				String result = sb.toString();
				System.out.println(result);
				*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		/*
		OutputStream output = null;

		try {
			output = new FileOutputStream(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			//핵심 코드
			//core code
			//output.write(formatWavToRaw(changeFormat(AudioToByte(file), FORMAT)));
			output.write((changeFormat(AudioToByte(file), FORMAT)));

			//Can delete
			//Just Test Code
			System.out.print("Success");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	private void exhaustInputStream(final InputStream is) {
        // InputStream.read() 에서 블럭 상태에 빠지기 때문에 따로 쓰레드를 구현하여 스트림을 소비한다.
        new Thread() {
            public void run() {
             BufferedReader br = new BufferedReader(new InputStreamReader(is));
             
                try {
                    String stdout = null;
                    System.out.println("=========================================================================================");
                    while ((stdout = br.readLine()) != null) {
                        System.out.println(stdout);
                    }
                    System.out.println("=========================================================================================");
                }
                catch(IOException ioe) {
                    ioe.printStackTrace();
                }
                finally {
                 try { if (br != null) br.close(); } catch (IOException e) { e.printStackTrace(); }
                }
            }
        }.start();
    }

	//Wav 파일에서 헤더 제거
	//Strip the header from the WAV file
	public byte[] formatWavToRaw(final byte[] audioFileContent) {
		return Arrays.copyOfRange(audioFileContent, 44, audioFileContent.length);
	}

	//기존의 Wav 파일(바이트 배열) 을 다른 형식의 Wav 형식 (바이트 배열) 로 변환
	//WAV to WAV (different audio format)
	public byte[] changeFormat(final byte[] audioFileContent, final AudioFormat audioFormat)
			throws IOException, UnsupportedAudioFileException {
		try (final AudioInputStream originalAudioStream = AudioSystem
				.getAudioInputStream(new ByteArrayInputStream(audioFileContent));
				final AudioInputStream formattedAudioStream = AudioSystem.getAudioInputStream(audioFormat,
						originalAudioStream);
				final AudioInputStream lengthAddedAudioStream = new AudioInputStream(formattedAudioStream, audioFormat,
						audioFileContent.length);
				final ByteArrayOutputStream convertedOutputStream = new ByteArrayOutputStream()) {
			AudioSystem.write(lengthAddedAudioStream, AudioFileFormat.Type.WAVE, convertedOutputStream);
			return convertedOutputStream.toByteArray();
		}
	}

	//기존의 wav 파일을 바이트 배열로 변환
	//Convert existing wav file to byte array
	public byte[] AudioToByte(File file) {
		try {
			File inFile = file;
			fstream = new FileInputStream(inFile);

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			BufferedInputStream in = new BufferedInputStream(fstream);

			while ((read = in.read(buff)) > 0) {
				out.write(buff, 0, read);
			}
			out.flush();
			audioBytes = out.toByteArray();

			// Do something with the stream
		} catch (FileNotFoundException ex) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return audioBytes;
	}
}


