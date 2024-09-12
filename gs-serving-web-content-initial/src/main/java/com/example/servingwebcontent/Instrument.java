package com.example.servingwebcontent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Instrument(int version, int instrumentId, String shortname, String longname, String requester) { }
