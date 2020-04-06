package de.hhu.website.infrastructure.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller class that handles all errors and exceptions.
 *
 * @author Snur Amin / Leon Geuer
 */

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
  private final transient int notFound = HttpStatus.NOT_FOUND.value(); //NOPMD
  private final transient int intServErr = HttpStatus.INTERNAL_SERVER_ERROR.value(); //NOPMD
  private final transient int forbidden = HttpStatus.FORBIDDEN.value(); //NOPMD

  @Override
  public String getErrorPath() {
    return "/error";
  }

  /**
   * This method is handling some basic errors, which could occur during browsing.
   *
   * @param request this returns the ERROR-CODE.
   * @return this returns the appropriate html-view.
   */
  @RequestMapping("/error")
  public String handleError(final HttpServletRequest request) {
    String errorType;
    final Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status == null) {
      errorType = "error-500";
    } else {
      final int statusCode = Integer.parseInt(status.toString());
      if (statusCode == notFound) {
        errorType = "error-404";
      } else if (statusCode == intServErr) {
        errorType = "error-500";
      } else if (statusCode == forbidden) {
        errorType = "error-403";
      } else {
        errorType = "error-500";
      }
    }
    return errorType;
  }
}