package com.lethanh98.annotation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author lethanh9398 <p>
 * email lethanh9398@gmail.com <p>
 * create Date 21-09-2019 10:45  <p>
 * document : <p>
 * <p>- vi :
 * <p>- en :
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Thành công"),
        @ApiResponse(code = 403, message = "Không có quyền truy cập, chưa gửi accessToken lên hoặc accessToken không có quyền truy cập"),
        @ApiResponse(code = 400, message = "Data client gửi lên server có vấn đề. Thiếu parameter , sai định dạng parameter "),
        @ApiResponse(code = 401, message = "Token hết hạn, bị thu hồi, không đúng, không hợp lệ..etc.., client nên lấy accessToken mới và thử lại"),
        @ApiResponse(code = 404, message = "Gán sai url để call api, chech lại url"),
}
)
public @interface ApiResponsesBase {
}
