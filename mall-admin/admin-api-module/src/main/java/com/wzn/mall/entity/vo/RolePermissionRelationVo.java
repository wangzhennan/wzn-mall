package com.wzn.mall.entity.vo;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RolePermissionRelationVo
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
@Data
@ApiModel("RolePermissionRelationVo" )
public class RolePermissionRelationVo implements Serializable {
    private static final long serialVersionUID = -17332186432735988L;
    /**
    * 主键
    */    
    @ApiModelProperty("主键")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long roleId;
    
        
    @ApiModelProperty("")
    private Long permissionId;
    
}