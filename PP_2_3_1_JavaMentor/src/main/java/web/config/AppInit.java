package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override// Метод, указывающий на класс конфигурации
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                DBConfig.class
        };
    }

    @Override// Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    @Override// Данный метод указывает url, на котором будет базироваться приложение
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override// Фильтрация скрытых запросов
    protected Filter[] getServletFilters() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{hiddenHttpMethodFilter};
    }
}