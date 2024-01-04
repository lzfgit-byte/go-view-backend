package cn.com.collect.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@TableName("t_sys_collect")
@Data
public class Collect implements Serializable {

    @TableId(value = "id")
    private String id;
    @TableField(value = "value")
    private String value;
    @TableField(value = "userId")
    private String userId;
    @OrderBy
    private String createDate;

}
