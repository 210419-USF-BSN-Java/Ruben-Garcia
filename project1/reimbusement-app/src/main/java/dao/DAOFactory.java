package dao;

public class DAOFactory {
	private static DAOFactory df; 
	private DAOFactory() {}
	public static DAOFactory getDAOFactory() {
		if(df == null) {
			df = new DAOFactory(); 
		}
		return df;
	}
	
	public ReimbDao getReimbDao() {
		return new ReimbDaoPostgres(); 
	}
	
	public UserDao getUserDao() {
		return new UserDaoPostgres(); 
	}
}
