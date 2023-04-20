package com.project.cmn.sample.validate.webclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.cmn.http.util.WebClientUtils;
import com.project.cmn.sample.validate.webclient.dto.CompletionsReq;
import com.project.cmn.sample.validate.webclient.dto.CompletionsRes;
import com.project.cmn.sample.validate.webclient.dto.ModelDto;
import com.project.cmn.sample.validate.webclient.dto.ModelsRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WebClientService {
    private static final String AUTHORIZATION = "Bearer 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";
    private static final String ORGANIZATION_KEY = "OpenAI-Organization";
    private static final String ORGANIZATION_VALUE = "org-bVzywIpRKZROcXy7WeZ8RxMA";

    private Map<String, String> getHttpHeaderMap() {
        Map<String, String> httpHeaderMap = new HashMap<>();

        httpHeaderMap.put(HttpHeaders.AUTHORIZATION, AUTHORIZATION);
        httpHeaderMap.put(ORGANIZATION_KEY, ORGANIZATION_VALUE);
        httpHeaderMap.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return httpHeaderMap;
    }

    public void retrieveModels() throws SSLException {
        ModelsRes response = (ModelsRes) WebClientUtils.get(getHttpHeaderMap(), "https://api.openai.com/v1/models", ModelsRes.class);

        log.debug("# {}", response);
    }

    public void retrieveModel(String modelId) throws SSLException {
        ModelDto response = (ModelDto) WebClientUtils.get(getHttpHeaderMap(), "https://api.openai.com/v1/models" + modelId, ModelDto.class);

        log.debug("# {}", response);
    }

    public void retrieveCompletions() throws JsonProcessingException, SSLException {
        CompletionsReq completionsReq = new CompletionsReq();

        completionsReq.setModel("text-davinci-003");
        completionsReq.setPrompt("Say this is a test");
        completionsReq.setMaxTokens(7);
        completionsReq.setTemperature(0D);

        CompletionsRes response = (CompletionsRes) WebClientUtils.post(getHttpHeaderMap(), "https://api.openai.com/v1/completions", completionsReq, CompletionsRes.class);

        log.debug("# {}", response);
    }
}
