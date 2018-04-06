package vn.jamek.baseweb.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import vn.jamek.baseweb.common.Constants;
import vn.jamek.baseweb.domain.User;
import vn.jamek.baseweb.dto.request.C001Request;
import vn.jamek.baseweb.dto.response.C001Response;
import vn.jamek.baseweb.dto.response.MessageResponse;
import vn.jamek.baseweb.dto.response.Response;
import vn.jamek.baseweb.services.impl.S001ServiceImpl;


import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NON_AUTHORITATIVE_INFORMATION;

@CrossOrigin
@RestController
@Transactional(value = "transactionManager", readOnly = true)
@RequestMapping(value = "/", headers = "Accept=application/json")
public class C000Controller {
	
	@Autowired
	S001ServiceImpl s001ServiceImpl;
	
	@RequestMapping(method = GET)
	public ResponseEntity<Object> init() {
		ObjectNode initData = JsonNodeFactory.instance.objectNode();
		initData.put("INIT_LT", "300");
		initData.put("INIT_PT", "200");
		initData.put("INIT_ST", "150");
		initData.put("INIT_GT", "50");
		initData.put("INIT_KT", "210");
		initData.put("INIT_ET", "560");
		return new ResponseEntity<Object>(initData, new HttpHeaders(), OK);
	}
	
	@Transactional(readOnly = false)
	@RequestMapping(method = POST, value = "/login")
	public ResponseEntity<Response> login(@RequestBody C001Request data) {
		System.out.println("Da vao trang login: ");
		if (Constants.EMPTY.equals(data.getUsername()) || Constants.EMPTY.equals(data.getPassword())) {
			C001Response res = new C001Response(false, "Input empty", new User());
			return new ResponseEntity<Response>(res, new HttpHeaders(), BAD_REQUEST);
		} else {
			List<User> users = s001ServiceImpl.login(data.getUsername(), data.getPassword());
			if (users.size() > 0) {
				User user = users.get(0);
				C001Response res = new C001Response(true, "Login successful", user);
				return new ResponseEntity<Response>(res, new HttpHeaders(), OK);
			}
		}

		C001Response res = new C001Response(false, "Login failure", new User());
		return new ResponseEntity<Response>(res, new HttpHeaders(), NON_AUTHORITATIVE_INFORMATION);
	}
}
