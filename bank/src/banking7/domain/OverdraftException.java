package banking7.domain;

//�Զ����쳣��

public class OverdraftException extends Exception {
	static final long serialVersionUID = -338753124229948L;

	private double deficit;	//��ʾ������

	public double getDeficit() {
		return deficit;
	}

	public OverdraftException(String msg, double deficit) {
		super(msg);
		this.deficit = deficit;
	}

}
