package modal;

public class Online_Test_Questions
{
	private String question;
	private String option_a;
	private String option_b;
	private String option_c;
	private String option_d;
	private String correct_answer;
	private String user_answer;
	private int sno;
	
	public Online_Test_Questions(String question, String option_a, String option_b, String option_c,String option_d,String correct_answer)
	{
		this.question=question;
		this.option_a=option_a;
		this.option_b=option_b;
		this.option_c=option_c;
		this.option_d=option_d;
		this.correct_answer=correct_answer;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public Online_Test_Questions()
	{}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption_a() {
		return option_a;
	}
	public void setOption_a(String option_a) {
		this.option_a = option_a;
	}
	public String getOption_b() {
		return option_b;
	}
	public void setOption_b(String option_b) {
		this.option_b = option_b;
	}
	public String getOption_c() {
		return option_c;
	}
	public void setOption_c(String option_c) {
		this.option_c = option_c;
	}
	public String getOption_d() {
		return option_d;
	}
	public void setOption_d(String option_d) {
		this.option_d = option_d;
	}
	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	public String toString()
	{
		return question+"\t"+option_a+"\t"+option_b+"\t"+option_c+"\t"+option_d+"\t"+correct_answer;
	}
}