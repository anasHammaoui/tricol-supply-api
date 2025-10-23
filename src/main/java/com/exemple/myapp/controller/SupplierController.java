package com.exemple.myapp.controller;

import com.google.gson.Gson;
import com.exemple.myapp.model.Supplier;
import com.exemple.myapp.service.SupplierService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.io.BufferedReader;
import java.util.List;

public class SupplierController extends AbstractController {

    private SupplierService supplierService;
    private final Gson gson = new Gson();

    public SupplierController() {
        // Explicitly set supported methods including PUT
        setSupportedMethods(new String[]{"GET", "POST", "PUT", "DELETE", "HEAD"});
    }

    public SupplierController(SupplierService supplierService){
        this();
        this.supplierService = supplierService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setContentType("application/json");
        String method = request.getMethod();
        String path = request.getPathInfo();

        try {
            if ("GET".equalsIgnoreCase(method) && (path == null || "/v1/suppliers".equals(path))) {
                List<Supplier> suppliers = supplierService.findAll();
                if (suppliers == null || suppliers.isEmpty()) {
                    response.getWriter().write("{\"error\":\"Suppliers list is empty\"}");
                } else {
                    response.getWriter().write(gson.toJson(suppliers));
                }

            } else if ("GET".equalsIgnoreCase(method) && path.matches("/v1/suppliers/\\d+")) {
                Long id = Long.parseLong(path.substring(path.lastIndexOf('/') + 1));
                Supplier supplier = supplierService.findById(id);
                if (supplier == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\":\"Supplier not found\"}");
                } else {
                    response.getWriter().write(gson.toJson(supplier));
                }

            } else if ("POST".equalsIgnoreCase(method) && "/v1/suppliers".equals(path)) {
                Supplier s = gson.fromJson(readBody(request), Supplier.class);
                supplierService.save(s);
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write("{\"message\":\"Supplier created successfully\"}");

            } else if ("PUT".equalsIgnoreCase(method) && path.matches("/v1/suppliers/\\d+")) {
                Long id = Long.parseLong(path.substring(path.lastIndexOf('/') + 1));
                Supplier s = gson.fromJson(readBody(request), Supplier.class);
                supplierService.update(id, s);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("{\"message\":\"Supplier updated successfully\"}");

            } else if ("DELETE".equalsIgnoreCase(method) && path.matches("/v1/suppliers/\\d+")) {
                Long id = Long.parseLong(path.substring(path.lastIndexOf('/') + 1));
                supplierService.delete(id);
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);

            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"error\":\"Endpoint not found\"}");
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\":\"Invalid ID format\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Internal server error: " + e.getMessage() + "\"}");
        }

        return null;
    }

    private String readBody(HttpServletRequest request) throws Exception {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
        }
        return sb.toString();
    }
}