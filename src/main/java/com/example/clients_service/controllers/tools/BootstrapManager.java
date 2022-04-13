package com.example.clients_service.controllers.tools;

import org.springframework.data.util.Pair;
import org.springframework.ui.Model;

public abstract class BootstrapManager {
    private static final Pair<String , String> bootstrapHead = Pair.of(
      "bootstrapHead",
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                    "    <link rel=\"stylesheet\"\n" +
                    "          href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css\"\n" +
                    "          integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\"\n" +
                    "          crossorigin=\"anonymous\">\n" +
                    "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n" +
                    "            integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n" +
                    "            crossorigin=\"anonymous\"></script>\n" +
                    "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js\"\n" +
                    "            integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\n" +
                    "            crossorigin=\"anonymous\"></script>\n" +
                    "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js\"\n" +
                    "            integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\"\n" +
                    "            crossorigin=\"anonymous\"></script>"
    );
    public static void setBootstrapHead(Model model){
        model.addAttribute(
                bootstrapHead.getFirst(),
                bootstrapHead.getSecond()
        );
    }
}
