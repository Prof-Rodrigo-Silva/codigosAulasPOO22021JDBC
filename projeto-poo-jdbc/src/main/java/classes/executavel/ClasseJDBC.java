package classes.executavel;

import java.sql.SQLException;
import java.util.List;

import classes.modelo.Aluno;
import classes.modelo.BeanAlunoFone;
import classes.modelo.Telefone;
import conexaojdbc.SingleConnection;
import dao.ClasseDAO;

public class ClasseJDBC {

	public static void main(String[] args) {
		
		//initBanco();
		//initSalvar();
		initListar();
		//initBuscar();
		//initAtualizar();
		//initDeletar();
		//salvarTelefone();
		//initListarAlunoTelefone();
		//initDeletarCascata();
		//initUltimoRegistro();
		
	}
	
	
	public static void initBanco() {
		SingleConnection.getConnetion();
	}
	
	
	public static void initSalvar() {
		Aluno aluno = new Aluno();
		ClasseDAO classeDao = new ClasseDAO();
		
		//classeDao.salvar(aluno);
		
		//aluno.setId(2L);
		aluno.setNome("Yúri");
		aluno.setEmail("yuri@gmail.com");
		
		classeDao.salvar(aluno);
	}
	
	public static void initListar() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			List<Aluno> list = classeDao.listar();
			
			for(Aluno aluno : list) {
				System.out.println(aluno.toString());
				System.out.println("----------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void initBuscar() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Aluno aluno = classeDao.buscar(4L);
			
			System.out.println(aluno.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initAtualizar() {
		
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Aluno aluno = classeDao.buscar(5L);
			
			aluno.setNome("Rodrigo");
			
			classeDao.atualizar(aluno);
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}
	
	public static void initDeletar() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			classeDao.deletar(7L);
					
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void salvarTelefone() {
		Telefone telefone = new Telefone();
		ClasseDAO classeDAO = new ClasseDAO();
		telefone.setNumero("99900334455");
		telefone.setTipo("comercial");
		telefone.setIdAluno(10L);
		
		classeDAO.salvarTelefone(telefone);
	}
	
	public static void initListarAlunoTelefone() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			List<BeanAlunoFone> list = classeDao.listarAlunoFone(11L);
			
			for(BeanAlunoFone beanAlunoFone : list) {
				System.out.println(beanAlunoFone.toString());
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void initDeletarCascata() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			classeDao.deletarCascata(10L);
					
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void initUltimoRegistro() throws SQLException {
		ClasseDAO classeDAO = new ClasseDAO();
		String id = classeDAO.ultimoRegistro();
		System.out.println(id);
	}
}
