package core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class BaseController {

    public <T>ResponseEntity<BaseResponse<T>> sendResponse(String message, T t) {
        BaseResponse<T> response = new BaseResponse<>(true, message, t);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public <T> BaseResponse<T> sendResponse(String message) {
        return new BaseResponse<>(true, message, null);
    }

    public ResponseEntity<BaseResponse<String>> sendError(String message) {
        return sendError(message, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<BaseResponse<String>> sendError(String message, HttpStatus httpStatus) {
        BaseResponse<String> response = new BaseResponse<>(false, message, null);
        return new ResponseEntity<>(response, httpStatus);
    }

}
