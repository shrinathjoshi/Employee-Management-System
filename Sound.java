package mu;

import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;
import javax.sound.*;

 public class Sound
{
	public static void main(String aths[])
	{
		success();
		failure();
	}
	public static void success()
	{
	try
		{
			String songFile="success.wav";
			InputStream in =new FileInputStream(songFile);
			AudioStream audioStream =new AudioStream(in);
			AudioPlayer.player.start(audioStream);
		}
	catch(Exception w)
		{
			System.out.println(w);
		}
	}

	public static void failure()
	{
	try
		{
			String songFile="failure.wav";
			InputStream in =new FileInputStream(songFile);
			AudioStream audioStream =new AudioStream(in);
			AudioPlayer.player.start(audioStream);
		}
	catch(Exception w)
		{
			System.out.println(w);
		}
	}


}