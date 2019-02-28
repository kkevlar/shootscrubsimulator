package com.github.kkevlar.scrubshootsim.server;

import java.io.IOException;
import java.net.Socket;

public class Player extends GenericServerClient {

	private String pos;
	private int id;
	private ShootServer server;
	
	public Player(int id, ShootServer server, Socket s) throws IOException 
	{
		super(server, s);
		this.setId(id);
		this.server = server;
	}

	@Override
	public void clientInit() 
	{
		server.sentToAll("id:" + id);
	}

	@Override
	public void incomingMessage(String read) {
		if(read.startsWith("pos:"))
		pos = read.substring("pos:".length());

	}

	@Override
	public void clientDisconnected() {
		// TODO Auto-generated method stub
		
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

}
