package com.uwoobeat.discordbot.global.utils;

import org.springframework.beans.factory.annotation.Value;

public class GoogleSheetsUtils {

    @Value("${google.sheets.id}")
    private String spreadsheetId;
}
