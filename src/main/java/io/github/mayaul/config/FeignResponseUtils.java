package io.github.mayaul.config;

import feign.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FeignResponseUtils {
    public static String getRequestBody(Response response) {
        if (response.request().requestBody() == null) {
            return "";
        }

        try {
            return new String(response.request().requestBody().asBytes(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            log.error(format("feign request body converting error - io.github.mayaul.response: %s", response), e);
            return "";
        }
    }

    public static String getResponseBody(Response response) {
        if (response.body() == null) {
            return "";
        }

        try (InputStream responseBodyStream = response.body().asInputStream()) {
            return IOUtils.toString(responseBodyStream, StandardCharsets.UTF_8.name());

        } catch (IOException e) {
            log.error(format("feign io.github.mayaul.response body converting error - io.github.mayaul.response: %s", response), e);
            return "";
        }
    }
}
