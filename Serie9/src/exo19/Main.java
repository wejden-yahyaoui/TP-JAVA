package exo19;

public class Main {

	public static void main(String[] args) {
		
		AnalyseBean analyseBean = new AnalyseBean();
		
		//question1
		System.out.println(analyseBean.getClassName(analyseBean));
		
		//question2
		try {
			System.out.println(analyseBean.getInstance
					(analyseBean.getClassName(analyseBean).getName()));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//question3
		Person person = new Person();
		Employee employee = new Employee();
		
		System.out.println(analyseBean.getProperties(person));
		System.out.println(analyseBean.getProperties(employee));

	}

}
