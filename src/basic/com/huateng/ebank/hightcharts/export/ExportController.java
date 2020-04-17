package com.huateng.ebank.hightcharts.export;

import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.fop.svg.PDFTranscoder;

public class ExportController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ExportController() {
        super();
    }

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processrequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processrequest(request, response);
    }

    public void processrequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");// 注意编码
        String type = request.getParameter("type");
        String svg = request.getParameter("svg");
        ServletOutputStream out = response.getOutputStream();
        if (null != type && null != svg) {
            // This line is necessary due to a bug in the highcharts SVG
            // generator for IE
            // I'm guessing it wont be needed later.
            svg = svg.replaceAll(":rect", "rect");
            String ext = "";
            Transcoder t = null;

            if (type.equals("image/png")) {
                ext = "png";
                t = new PNGTranscoder();

            } else if (type.equals("image/jpeg")) {
                ext = "jpg";
                t = new JPEGTranscoder();

            } else if (type.equals("application/pdf")) {
                ext = "pdf";
                t = new PDFTranscoder();

            } else if (type.equals("image/svg+xml")) {
                ext = "svg";
            }

            response.addHeader("Content-Disposition", "attachment; filename=chart." + ext);
            response.addHeader("Content-Type", type);

            if (null != t) {
                TranscoderInput input = new TranscoderInput(new StringReader(svg));
                TranscoderOutput output = new TranscoderOutput(out);
                try {
                    t.transcode(input, output);
                } catch (TranscoderException e ) {
                    out.print("Problem transcoding stream. See the web logs for more details.");
                    e.printStackTrace();
                }

            } else if ("svg".equals(ext)) {
                out.print(URLEncoder.encode(svg, "UTF-8"));
            } else {
                out.print("Invalid type: " + URLEncoder.encode(type, "UTF-8"));
            }
        } else {
            response.addHeader("Content-Type", "text/html");
            out.println(
                    "This line is necessary due to a bug in the highcharts SVG.generator for IE;I'm guessing it wont be needed later.");
        }
        out.flush();
        out.close();
    }

}
