package banking7.domain;

//自定义异常类

public class OverdraftException extends Exception {
	static final long serialVersionUID = -338753124229948L;

	private double deficit;	//表示不足金额

	public double getDeficit() {
		return deficit;
	}

	public OverdraftException(String msg, double deficit) {
		super(msg);
		this.deficit = deficit;
	}

}
