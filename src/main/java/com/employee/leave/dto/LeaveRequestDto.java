package com.employee.leave.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LeaveRequestDto {

    @NotNull @FutureOrPresent
    LocalDate startDate;

    @NotNull @FutureOrPresent
    LocalDate endDate;

    @NotBlank
    private String reason;

    public @NotNull @FutureOrPresent LocalDate getStartDate() {
        return startDate;
    }

    public @NotNull @FutureOrPresent LocalDate getEndDate() {
        return endDate;
    }

    public @NotBlank String getReason() {
        return reason;
    }

    public void setStartDate(@NotNull @FutureOrPresent LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(@NotNull @FutureOrPresent LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReason(@NotBlank String reason) {
        this.reason = reason;
    }
}
