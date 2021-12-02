package shop.templete;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class TemplateEngine {
    private final Configuration conf;

    private TemplateEngine() {
        this.conf = new Configuration(Configuration.VERSION_2_3_31) {{
            setClassLoaderForTemplateLoading(TemplateEngine.class.getClassLoader(), "templates");
            setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
            setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            setLogTemplateExceptions(false);
            setWrapUncheckedExceptions(true);
        }};
    }

    public static TemplateEngine folder(final String path_from_project_root) {
        return new TemplateEngine();
    }

    public static TemplateEngine resources(final String path_from_project_resources) {
        return new TemplateEngine();
    }

    public void render(String template, Map<String, Object> data, HttpServletResponse resp) {
        resp.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));

        try (PrintWriter w = resp.getWriter()) {
            conf.getTemplate(template).process(data, w);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException("Freemarker error", e);
        }
    }
}
