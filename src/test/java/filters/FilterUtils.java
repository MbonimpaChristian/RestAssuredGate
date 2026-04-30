package filters;

import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterUtils {

    public static List<Filter> getLoggingFilters() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter(LogDetail.BODY));
        return filters;
    }

}
