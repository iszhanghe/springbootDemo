package com.ssy.restfuluser;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.io.File;

/**
 * <p>
 * 通过junit test 生成代码
 * 演示：自定义代码模板
 * 默认不会覆盖已有文件，如果需要覆盖，配置GlobalConfig.setFileOverride(true)
 * </p>
 *
 * @author yuxiaobin
 * @date 2018/11/29
 */
public class MpGeneratorTest {


    @Test
    public void generateCode() {
        File file = new File("");
        String path = file.getAbsolutePath();

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path + "/src/main/java");// 需要生成的目录
        gc.setFileOverride(true);// 是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setAuthor("zhanghe");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.ORACLE);
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("wallet");
        dsc.setPassword("wallet");
//        dsc.setUrl("jdbc:mysql://localhost:3306/cloud?useSSL=false&characterEncoding=utf8");
        dsc.setUrl("jdbc:oracle:thin:@36.153.10.114:11521/javatest");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//        strategy.setTablePrefix();
//        strategy.setInclude("W_USRACCOUNTTJN");
        strategy.setInclude("W_BANKCARDINFO","W_CHNACCINFO","W_CHINFO","W_CORGINFO","W_LIFTTJNCMB","W_ORDINF"
        ,"W_PAYTJNCMB","W_REGTJNCMB","W_USERCARDINFO","W_USRACCOUNTINF","W_USRACCOUNTTJN","W_USRINF");
        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity("com.ytx.wallet.model");
        pc.setMapper("com.ytx.wallet.dao");
        pc.setXml("mapper");
        pc.setController("com.ytx.wallet.controller");
        pc.setService("com.ytx.wallet.service");
        pc.setServiceImpl("com.ytx.wallet.service.impl");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();

    }
}
