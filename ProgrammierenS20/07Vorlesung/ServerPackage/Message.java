package ServerPackage;

import java.io.Serializable;

public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	String userName;

	
	@Override
	public String toString() {
		return "Message [text=" + text + ", userName=" + userName + "]";
	}

	public Message(String text, String userName) {
		super();
		this.text = text;
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
