package kr.co.ooweat.coupon;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
@Component
public class CouponInterceptor implements HandlerInterceptor {
    public List allowList = Arrays.asList("/api/v1/coupons/**");
    public List deninedList = Arrays.asList("/assets/**");
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) {
        
        return true;
    }
}
