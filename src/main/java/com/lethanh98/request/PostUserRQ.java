package com.lethanh98.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PostUserRQ {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(notes = "Tên đầu tiên người dùng", required = true, example = "Lê")
  @NotNull(message = "firstName là bắt buộc")
  private String firstName;

  @NotNull(message = "lastName là bắt buộc")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(notes = "Tên cuối cùng người dùng", required = true, example = "Thành")
  private String lastName;
}
