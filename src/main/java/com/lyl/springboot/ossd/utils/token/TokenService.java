package com.lyl.springboot.ossd.utils.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lyl.springboot.ossd.domain.Student;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenService {
    // 生成token
    public String getToken(Student student) {
        String token="";
        token= JWT.create().withAudience(student.getStudentId())
                .sign(Algorithm.HMAC256(student.getStudentPwd()));
        return token;
    }
}
