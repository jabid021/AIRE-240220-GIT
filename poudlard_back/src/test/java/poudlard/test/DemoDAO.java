package poudlard.test;

import poudlard.dao.DAOSort;

public class DemoDAO {

	public static void main(String[] args) {
		DAOSort daoSort = new DAOSort();
		System.out.println(daoSort.findAll());

	}

}
