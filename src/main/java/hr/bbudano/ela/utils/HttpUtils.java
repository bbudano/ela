package hr.bbudano.ela.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class HttpUtils {

    public URI getLocationUri(HttpServletRequest httpServletRequest, Long resourceId) {
        return ServletUriComponentsBuilder
                .fromRequest(httpServletRequest)
                .path("/{id}")
                .buildAndExpand(resourceId)
                .toUri();
    }

}
