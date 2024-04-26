package spring.formation.todo.model;

public interface Views {
	public interface ViewCommon {}
	
	public interface ViewListe extends ViewCommon {}
	
	public interface ViewTodo extends ViewCommon {}
	
	public interface ViewTodoDetail extends ViewTodo {}
	
	public interface ViewUtilisateur extends ViewCommon {}
	
	public interface ViewUtilisateurDetail extends ViewUtilisateur {}
}
