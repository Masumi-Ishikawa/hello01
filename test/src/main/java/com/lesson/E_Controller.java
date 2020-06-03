package com.lesson;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class E_Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

	@GetMapping("/Expression")
	public String getExpression(Model model) {
		return "Expression";
	}

	@PostMapping("/Expression")
	public String postExpression(Model model) {

		while(true) {
			int randomValue = new Random().nextInt(27)+1;

	        // SQL文作成
	        String sql = "SELECT count(*) as count FROM users_e WHERE flg = \"1\"";

	        Map<String, Object> user = jdbcTemplate.queryForMap(sql);

	        System.out.println((Long)user.get("count"));

	        if((Long)user.get("count")< 27) {
	            // SQL文作成
		        sql = "SELECT count(*) as count FROM users_e WHERE user_id= ? and flg = ?";

		        // ？の箇所を置換するデータの配列を定義
		        Object[] param = {randomValue,"1"};

		        user = jdbcTemplate.queryForMap(sql, param);

		        //件数が0件でなかったら値取得
		        if((Long)user.get("count")<= 0) {

			        // SQL文作成
			        sql = "SELECT * FROM users_e WHERE user_id= ?";

			        Object[] param2 = {randomValue};

				    user = jdbcTemplate.queryForMap(sql, param2);

				    model.addAttribute("name",String.valueOf(user.get("user_name"))+"さん");

		            // SQL文作成
		            sql = "UPDATE users_e SET flg=? WHERE user_id=?";

		            // ？の箇所を置換するデータの配列を定義
		            Object[] param3 = {"1",randomValue};

		            // クエリを実行
		            jdbcTemplate.update(sql, param3);

				    break;
		        }
	        }else {
	        	model.addAttribute("name","全員発表終わりました。");
			    break;
	        }


		}
		return "Expression";
	}
}
