package com.cejv456.jip.business;

import com.cejv456.jip.data.InpatientBean;
import com.cejv456.jip.data.MedicationBean;
import com.cejv456.jip.data.PatientBean;
import com.cejv456.jip.data.SurgicalBean;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 *
 * @author Jianyu Feng
 */
public class PatientReport {

    private PatientBean pb;
    private NumberFormat nf;
    private DateFormat df;

    public PatientReport() {
        super();

        nf = NumberFormat.getCurrencyInstance();
        df = DateFormat.getDateTimeInstance();
    }

    /**
     * generate patient report
     *
     * @param pb patient bean
     * @return
     */
    public String generatePatientReport() {
        List<Object> ibl = pb.getIb();
        List<Object> sbl = pb.getSb();
        List<Object> mbl = pb.getMb();

        InpatientBean ib;
        SurgicalBean sb;
        MedicationBean mb;

        BigDecimal total = new BigDecimal("0");

        StringBuilder report = new StringBuilder();
        report.append("<style>body{font-family:verdana; font-size: 12px;}</style><body>");
        report.append("<p><b>Patient:</b> ").append(pb.getFirstName()).append(" ");
        report.append(pb.getLastName()).append("<br>");
        report.append("<p><b>Diagnosis:</b> ").append(pb.getDiagnosis());
        report.append("<p><b>Admission Date:</b> ").append(pb.getAdmissionDate());
        report.append("<p><b>Release Date:</b> ").append(pb.getReleaseDate() == null ? "Not released yet":pb.getReleaseDate());

        report.append("<ul>");
        // inpatient details
        if (ibl != null) {
            report.append("<li>Inpatient Details</li>").append("<br>");
            for (int i = 0; i < ibl.size(); i++) {
                ib = (InpatientBean) ibl.get(i);
                report.append("Date: ").append(df.format(ib.getDate())).append("<br>");
                if (ib.getDailyRoomRate() != null) {
                    report.append("Room Rate: ").append(nf.format(ib.getDailyRoomRate())).append("<br>");
                    total = total.add(ib.getDailyRoomRate(), MathContext.DECIMAL128);
                }
                if (ib.getRoomServicesFee() != null) {
                    report.append("Room Service: ").append(nf.format(ib.getRoomServicesFee())).append("<br>");
                    total = total.add(ib.getRoomServicesFee(), MathContext.DECIMAL128);
                }
                if (ib.getRoomSuppliesFee() != null) {
                    report.append("Room Supplies: ").append(nf.format(ib.getRoomSuppliesFee())).append("<br>");
                    total = total.add(ib.getRoomSuppliesFee(), MathContext.DECIMAL128);
                }
                
                report.append("<p>");
            }
        }

        // surgical details
        if (sbl != null) {
            report.append("<li>Surgical Details </li>").append("<br>");
            for (int i = 0; i < sbl.size(); i++) {
                sb = (SurgicalBean) sbl.get(i);
                report.append("Date: ").append(df.format(sb.getDate())).append("<br>");
                if (sb.getOperatingRoomFee() != null) {
                    report.append("Operation Room Fee: ").append(nf.format(sb.getOperatingRoomFee())).append("<br>");
                    total = total.add(sb.getOperatingRoomFee(), MathContext.DECIMAL128);
                }
                if (sb.getSurgeonFee() != null) {
                    report.append("Surgeon Fee: ").append(nf.format(sb.getSurgeonFee())).append("<br>");
                    total = total.add(sb.getSurgeonFee(), MathContext.DECIMAL128);
                }
                if (sb.getSurgicalSuppliesFee() != null) {
                    report.append("Surgical Supplies Fee: ").append(nf.format(sb.getSurgicalSuppliesFee())).append("<br>");
                    total = total.add(sb.getSurgicalSuppliesFee(), MathContext.DECIMAL128);
                }
                
                report.append("<p>");
            }
        }

        // medication details
        if (mbl != null) {
            report.append("<li>Medication Details</li>").append("<br>");
            for (int i = 0; i < mbl.size(); i++) {
                mb = (MedicationBean) mbl.get(i);
                report.append("Date: ").append(df.format(mb.getDate())).append("<br>");
                if (mb.getCostPerUnit() != null) {
                    BigDecimal b = mb.getCostPerUnit().multiply(new BigDecimal(mb.getNumberOfUnits()));
                    report.append("Medication Fee: ").append(nf.format(b)).append("<br>");
                    total = total.add(b, MathContext.DECIMAL128);
                }
                
                report.append("<p>");
            }
        }

        report.append("</ul><b>Total: ").append(nf.format(total)).append("</b>");
        report.append("</body>");
        
        return report.toString();
    }

    public PatientBean getPb() {
        return pb;
    }

    public void setPb(PatientBean pb) {
        this.pb = pb;
    }
}
