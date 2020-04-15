package com.wzn.mall.entity.vo;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * AdminRoleRelationVo
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("AdminRoleRelationVo" )
public class AdminRoleRelationVo implements Serializable {
    private static final long serialVersionUID = 717377782351565967L;
    /**
    * 主键
    */    
    @ApiModelProperty("主键")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long adminId;
    
        
    @ApiModelProperty("")
    private Long roleId;
    
}