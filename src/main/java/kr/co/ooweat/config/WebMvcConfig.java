package kr.co.ooweat.config;

import kr.co.ooweat.coupon.CouponInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        CouponInterceptor couponInterceptor = new CouponInterceptor();
        registry.addInterceptor(couponInterceptor)
            .addPathPatterns(couponInterceptor.allowList)
            .excludePathPatterns(couponInterceptor.deninedList);
    }
    
}
