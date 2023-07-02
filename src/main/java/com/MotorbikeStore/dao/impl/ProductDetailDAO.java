package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.IProductDetailDAO;
import com.MotorbikeStore.mapper.ProductDetailMapper;
import com.MotorbikeStore.model.ProductDetailModel;

public class ProductDetailDAO extends AbstractDAO<ProductDetailModel> implements IProductDetailDAO {

	@Override
	public List<ProductDetailModel> findAll() {
		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id and s.motors_id = m.motors_id;";

		return query(sql, new ProductDetailMapper());
	}

	@Override
	public List<ProductDetailModel> findByMotorcyclesID(int moID) {

		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id and m.motors_id = ? and s.motors_id = m.motors_id;";

		return query(sql, new ProductDetailMapper(), moID);
	}

	@Override
	public List<ProductDetailModel> findNumberOfMotor(int numberMotor) {
		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold , motor_desc from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id and s.motors_id = m.motors_id LIMIT ? ;";
				

		return query(sql, new ProductDetailMapper(), numberMotor);
	}

	@Override
	public ProductDetailModel findOneByAmotorId(int aMotorId) {
		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id and a.a_motor_id = ? and s.motors_id = m.motors_id;";
		
		List<ProductDetailModel> list = query(sql, new ProductDetailMapper(), aMotorId);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<ProductDetailModel> searchByName(String txtSearch) {
		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && aMotorDesc like ? and s.motors_id = m.motors_id ;";
		
		return query(sql, new ProductDetailMapper(), "%"+txtSearch+"%");
	}

	@Override
	public List<ProductDetailModel> filterPriceAround(int fromNum, int toNum) {
		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id ;";
		return query(sql, new ProductDetailMapper(), fromNum, toNum);
	}

	@Override
	public List<ProductDetailModel> filterColor(String color) {
		String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ? and s.motors_id = m.motors_id;";
		return query(sql, new ProductDetailMapper(), "%"+color+"%");
	}

	@Override
	public List<ProductDetailModel> filterCC(int fromNum, int toNum) {
		String sql = "select aMotorDesc, s.engine_torque, a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s, motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && s.motors_id = m.motors_id && s.engine_torque between ? and ?;";
		return query(sql, new ProductDetailMapper(), fromNum, toNum);
	}

	@Override
	public List<ProductDetailModel> filterBranch(String branch) {
		String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && branch like ? and s.motors_id = m.motors_id;";
		return query(sql, new ProductDetailMapper(), "%"+branch+"%");
	}

	@Override
	public List<ProductDetailModel> findNumberOfMotorFeature(int numberMotor, String feature) {
		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && aMotorDesc like ? and s.motors_id = m.motors_id LIMIT ?  ;";
		return query(sql, new ProductDetailMapper(), "%"+feature+"%",numberMotor );
	}

	@Override
	public List<ProductDetailModel> filterMix(int firstPrice, int seconPrice, String color, int firstCC, int seconCC,
			String branch, int numberMotor) {
		if(firstPrice != 0 && seconPrice != 0 && !color.equals("all") && firstCC != 0 && seconCC != 0 && !branch.equals("all")  && numberMotor != 0) {
			//price and color and CC and branch and number 
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price  between ? and ? and s.motors_id = m.motors_id && color like ? && s.engine_torque between ? and ? && branch like ? LIMIT ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, color, firstCC, seconCC, "%"+branch+"%", numberMotor );
			
		}else if(firstPrice != 0 && seconPrice != 0 && !color.equals("all") && firstCC != 0 && seconCC != 0 && !branch.equals("all")){
			//price and color and CC and branch 
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id && color like ? && s.engine_torque between ? and ? && branch like ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, color, firstCC, seconCC, "%"+branch+"%");
		
		}else if(firstPrice != 0 && seconPrice != 0  && firstCC != 0 && seconCC != 0 && !branch.equals("all") && numberMotor != 0 ) {
			// price and CC and branch and number 
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id && s.engine_torque between ? and ? && branch like ? LIMIT ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, firstCC, seconCC, "%"+branch+"%", numberMotor);
			
		}else if(!color.equals("all") && firstCC != 0 && seconCC != 0 && !branch.equals("all") && numberMotor != 0) {
			//color and CC and branch and number 
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ?  and s.motors_id = m.motors_id  && s.engine_torque between ? and ? && branch like ? LIMIT ? ;";
			return query(sql, new ProductDetailMapper(), "%"+color+"%",  firstCC, seconCC, "%"+branch+"%", numberMotor);
		}else if(firstPrice != 0 && seconPrice != 0 && !color.equals("all") && firstCC != 0 && seconCC != 0){
		
			//price and color and CC 
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id && color like ? && s.engine_torque between ? and ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice,  "%"+color+"%",firstCC, seconCC );
			
			
		}else if(firstPrice != 0 && seconPrice != 0 && firstCC != 0 && seconCC != 0 && !branch.equals("all") ) {
			//price and CC and branch 
			
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id  &&  price between ? and ? and s.motors_id = m.motors_id && s.engine_torque between ? and ? && branch like ?;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, firstCC, seconCC , "%"+branch+"%");
		}else if(firstPrice != 0 && seconPrice != 0 && !branch.equals("all")  && numberMotor != 0) {
			//price and branch and number 
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id && branch like ? LIMIT ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice , "%"+branch+"%" , numberMotor);
			
			
		}else if(!color.equals("all") && firstCC != 0 && seconCC != 0 && !branch.equals("all")) {
			//color and CC and branch 
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ? and s.motors_id = m.motors_id  && s.engine_torque between ? and ? && branch like ?;";
			return query(sql, new ProductDetailMapper(), "%"+color+"%" , firstCC, seconCC , "%"+branch+"%" );
		}else if(!color.equals("all") && !branch.equals("all") && numberMotor != 0) {
			//color and branch and number 
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ? && branch like ? and s.motors_id = m.motors_id LIMIT ?;";
			return query(sql, new ProductDetailMapper(), "%"+color+"%" , "%"+branch+"%", numberMotor );
			
		}else if(firstCC != 0 && seconCC != 0 && !branch.equals("all") && numberMotor != 0) {
			//CC and branch and number 
			String sql = "select aMotorDesc, s.engine_torque, a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s, motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && s.motors_id = m.motors_id && s.engine_torque between ? and ? && branch like ?   LIMIT ? ;";
			return query(sql, new ProductDetailMapper(),firstCC, seconCC,  "%"+branch+"%", numberMotor );
			
		}
		else if(firstPrice != 0 && seconPrice != 0 && !color.equals("all")) {
			//price and color
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id && color like ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, "%"+color+"%" );
			
			
		}else if(firstPrice != 0 && seconPrice != 0 && firstCC != 0 && seconCC != 0) {
			//price and CC
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id && s.engine_torque between ? and ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, firstCC, seconCC );
			
		}else if(firstPrice != 0 && seconPrice != 0 && !branch.equals("all")) {
			//price and branch 
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id && branch like ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, "%"+branch+"%" );
			
		}else if(firstPrice != 0 && seconPrice != 0 && numberMotor != 0) {
			//price and number 
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id LIMIT ? ;";
			return query(sql, new ProductDetailMapper(), firstPrice, seconPrice, numberMotor );
			
		}else if(!color.equals("all") && firstCC != 0 && seconCC != 0) {
			//color and CC 
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ?  and s.motors_id = m.motors_id  && s.engine_torque between ? and ? ;";
			return query(sql, new ProductDetailMapper(), "%"+color+"%" , firstCC, seconCC );
			
			
		}else if(!color.equals("all") && !branch.equals("all")) {
			//color and branch 
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ? && branch like ? and s.motors_id = m.motors_id ;";
			return query(sql, new ProductDetailMapper(),"%"+color+"%"  ,"%"+branch+"%"  );
		}else if(!color.equals("all") && numberMotor != 0) {
			//color and number
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ? and s.motors_id = m.motors_id LIMIT ?;";
			return query(sql, new ProductDetailMapper(), "%"+color+"%" , numberMotor );
			
		}else if (firstCC != 0 && seconCC != 0 && !branch.equals("all")) {
			//CC and branch 
			String sql = "select aMotorDesc, s.engine_torque, a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s, motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && s.motors_id = m.motors_id  && s.engine_torque between ? and ? && branch like ?;";
			return query(sql, new ProductDetailMapper(),firstCC, seconCC  , "%"+branch+"%" );
			
		}else if(firstCC != 0 && seconCC != 0 && numberMotor != 0) {
			//CC and number 
			String sql = "select aMotorDesc, s.engine_torque, a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s, motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && s.motors_id = m.motors_id && s.engine_torque between ? and ? LIMIT ?;";
			return query(sql, new ProductDetailMapper(),firstCC, seconCC  , numberMotor);
		}else if(!branch.equals("all") && numberMotor != 0) {
			//Branch and number 
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && branch like ? and s.motors_id = m.motors_id LIMIT ?;";
			return query(sql, new ProductDetailMapper(),"%"+branch+"%" , numberMotor);
			
		}
		else if(firstPrice != 0 && seconPrice != 0) {
			//price
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id &&  price between ? and ? and s.motors_id = m.motors_id ;";
			return query(sql, new ProductDetailMapper(),firstPrice, seconPrice);
		}else if(!color.equals("all")  ) {
			//color
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && color like ? and s.motors_id = m.motors_id;";
			return query(sql, new ProductDetailMapper(),"%"+color+"%"  );
		}else if(firstCC != 0 && seconCC != 0 ) {
			//CC
			String sql = "select aMotorDesc, s.engine_torque, a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s, motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && s.motors_id = m.motors_id && s.engine_torque between ? and ?;";
			return query(sql, new ProductDetailMapper(),firstCC, seconCC);
			
		}else if(!branch.equals("all")) {
			//branch
			String sql ="select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id && branch like ? and s.motors_id = m.motors_id;";
			return query(sql, new ProductDetailMapper(), "%"+branch+"%");
		}else if(numberMotor != 0) {
			//numberMotor
			String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold , motor_desc from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id and s.motors_id = m.motors_id LIMIT ? ;";
			return query(sql, new ProductDetailMapper(),numberMotor);
			
		}
		
		String sql = "select aMotorDesc, s.engine_torque,a.motors_id, a_motor_id, motors_name, version, motor_type, branch, style,color, price,date_insert, check_sold,  motor_desc  from specification as s,motorcycles as m, a_motorcycle as a where a.motors_id = m.motors_id and s.motors_id = m.motors_id;";

		return query(sql, new ProductDetailMapper());
	}

}
