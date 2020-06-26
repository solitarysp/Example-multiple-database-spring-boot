package com.lethanh98.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBase<T> implements Serializable {
  public static final String ApiModelPropertyBase = ""
      + "\n" + 200 + " : thành công"
      + "\n" + 201 + " : Có một lỗi gì đó ở code logic bên server gây ra" +
      "";


  private Integer status;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T data;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<String> msgError;

  public ResponseBase(Integer status) {
    this.status = status;
  }

  public ResponseBase(Integer status, List<String> msgError) {
    this.status = status;
    this.msgError = msgError;
  }

  public ResponseBase() {
    status = HttpStatus.OK.value();
  }

  @ApiModelProperty(notes = ApiModelPropertyBase
  )
  public Integer getStatus() {
    return status;
  }
}
