import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanglj
 * @date 2024/3/18
 */
public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        cfg.setNumberFormat("0.######");
        cfg.setDefaultEncoding("UTF-8");
        Template template = cfg.getTemplate("myweb.html.ftl");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentYear",2024);
        List<Object> list = new ArrayList<>();
        Map<String, Object> itemMap1 = new HashMap<>();
        itemMap1.put("url","www.baidu,com");
        itemMap1.put("label","百度");
        Map<String, Object> itemMap2 = new HashMap<>();
        itemMap2.put("url","www.jd,com");
        itemMap2.put("label","京东");
        list.add(itemMap1);
        list.add(itemMap2);
        map.put("menuItems",list);
        FileWriter out = new FileWriter("myweb.html");
        template.process(map,out);
    }
}
