package com.kwq.algorithm;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author kongweiqiang
 *
 */
public class Generator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//MBG执行过程中的警告信息
		List<String> warnings = new ArrayList<String>();
		//当生成的代码重复时，覆盖源代码
		boolean overwrite = true;
		//读取MBG配置文件
		InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
		Configuration configuration = null;
		try {
			configuration = cp.parseConfiguration(is);
			is.close();
			//创建MBG
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
			//执行生成代码
			myBatisGenerator.generate(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		for (String warning : warnings) {
			System.out.println(warning);
		}
	}

}
