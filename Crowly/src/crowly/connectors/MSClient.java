package crowly.connectors;

import java.util.ArrayList;
import java.util.Scanner;

import crowly.Json;
import crowly.library.*;

public class MSClient implements IConstants
{
	private ArrayList<Cuerpo> Cuerpos;
	private ArrayList<VideoResponse> VideosPendientes;
	
	public ArrayList<Cuerpo> getCuerpos() {
		return Cuerpos;
	}

	public ArrayList<VideoResponse> getVideosPendientes() {
		return VideosPendientes;
	}
	
	public MSClient()
	{
		Cuerpos = new ArrayList<Cuerpo>();
		VideosPendientes = new ArrayList<VideoResponse>();
	}
	
	public void procesarVideo(String pURLVideo)
	{
		// puedo tener el URL hardcoded y aqui armo el PayLoad
		String payload = POST_BODY.replace("@@URL@@", pURLVideo);
		VideoResponse videoResp = HttpRequestor.post(MCS_URL, payload, MCS_IDKEY);
		if (videoResp!=null)
		{
			VideosPendientes.add(videoResp);
			System.out.println("Respuesta: ");
			System.out.println(videoResp.getContent());
			System.out.println("Listo");
		}
	}
	
	public void procesarRespuestaVideo(VideoResponse videoResponse)
	{
		HttpRequestor.get(videoResponse, MCS_IDKEY);
	}
		
	private void cargarCuerpos(VideoResponse videoResponse)
	{
		Json json = new Json();
		json.videoResponse = videoResponse;
		json.generateBodys();
		Cuerpos = json.getCuerpos();
		// aqui proceso el Json creando los objetos Cuerpo que vienen
		// en el Json y los meto uno a uno en la lista de Cuerpos
	}
}
