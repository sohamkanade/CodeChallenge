package com.home.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ListCalculation {
	private static final String RETENTION_INDICATOR = "R";

	public void cal() {
		List<Invoice> rawInvoices = new ArrayList<>();
		Invoice inv1 = new Invoice();
		inv1.setRetentionIndicator(RETENTION_INDICATOR);
		inv1.setInvoiceGrossAmount(new BigDecimal("500"));
		rawInvoices.add(inv1);

		Invoice inv2 = new Invoice();
		inv2.setRetentionIndicator(RETENTION_INDICATOR);
		inv2.setInvoiceGrossAmount(new BigDecimal("800"));
		rawInvoices.add(inv2);

		// chronologically
//		Comparator<Retention> retentionComparator = (r1, r2) -> {
//			if(r1.getInvoiceDate().compareTo(r2.getInvoiceDate()) != 0) {
//				return r1.getInvoiceDate().compareTo(r2.getInvoiceDate());
//			}
//			return r1.getRetentionAmount().compareTo(r2.getRetentionAmount());
//		};
		
		Comparator<Retention> retentionComparatorByDate = (r1, r2) -> r1.getInvoiceDate().compareTo(r2.getInvoiceDate());
		Comparator<Retention> retentionComparatorByAmount = (r1, r2) -> r1.getRetentionAmount().compareTo(r2.getRetentionAmount());
		Comparator<Retention> retentionComparator = retentionComparatorByDate.thenComparing(retentionComparatorByAmount);
		

		rawInvoices
		.stream()
		.filter(invoice -> StringUtils.containsIgnoreCase(invoice.getRetentionIndicator(), RETENTION_INDICATOR) && null != invoice.getInvoiceGrossAmount())
		.forEach(retentionInvoice -> {
			try {
				Invoice invoice = new Invoice();
				invoice.setRetentionIndicator(RETENTION_INDICATOR);

				getRetentions()
				.stream()
				.filter(r -> null != r.getInvoiceDate() && null != r.getRetentionAmount())
				.sorted(retentionComparator)
				.forEach(retention -> {
					if(retentionInvoice.getInvoiceGrossAmount().compareTo(BigDecimal.ZERO) > 0) {
						System.out.println("retention invoice gross amount: " + retentionInvoice.getInvoiceGrossAmount().toPlainString());
						InvoiceComponent component = new InvoiceComponent();
						System.out.println("retention amount: " + retention.getRetentionAmount().toPlainString());
						component.setItemGrossAmount(retentionInvoice.getInvoiceGrossAmount().min(retention.getRetentionAmount()));
						retentionInvoice.setInvoiceGrossAmount( retentionInvoice.getInvoiceGrossAmount().subtract(retention.getRetentionAmount()));
						System.out.println("component gross amount: " + component.getItemGrossAmount().toPlainString());
						invoice.getComponents().add(component);
					}
				});

			} catch(Exception e) {
				throw e;
			}

		});
	}

//	private

	public List<Retention> getRetentions() {
		List<Retention> retentions = new ArrayList<>();
		Retention ret1 = new Retention();
		ret1.setRetentionAmount(new BigDecimal("300"));
		ret1.setInvoiceDate(new Date());
		retentions.add(ret1);

		Retention ret2 = new Retention();
		ret2.setRetentionAmount(new BigDecimal("400"));
		ret2.setInvoiceDate(new Date());
		retentions.add(ret2);

		Retention ret3 = new Retention();
		ret3.setRetentionAmount(new BigDecimal("200"));
		ret3.setInvoiceDate(new Date());
		retentions.add(ret3);
		return retentions;
	}

	public static void main(String[] args) {
		ListCalculation lc = new ListCalculation();
		lc.cal();
	}

	public class Invoice {
		private BigDecimal InvoiceGrossAmount;
		private String RetentionIndicator;
		private List<InvoiceComponent> components = new ArrayList<>();

		public List<InvoiceComponent> getComponents() {
			return components;
		}

		public String getRetentionIndicator() {
			return RetentionIndicator;
		}

		public void setRetentionIndicator(String retentionIndicator) {
			RetentionIndicator = retentionIndicator;
		}

		public BigDecimal getInvoiceGrossAmount() {
			return InvoiceGrossAmount;
		}

		public void setInvoiceGrossAmount(BigDecimal invoiceGrossAmount) {
			InvoiceGrossAmount = invoiceGrossAmount;
		}
	}

	public class Retention {
		private Date InvoiceDate;
		private BigDecimal RetentionAmount;

		public BigDecimal getRetentionAmount() {
			return RetentionAmount;
		}

		public void setRetentionAmount(BigDecimal retentionAmount) {
			RetentionAmount = retentionAmount;
		}

		public Date getInvoiceDate() {
			return InvoiceDate;
		}

		public void setInvoiceDate(Date invoiceDate) {
			InvoiceDate = invoiceDate;
		}
	}

	public class InvoiceComponent {
		private BigDecimal ItemGrossAmount;

		public BigDecimal getItemGrossAmount() {
			return ItemGrossAmount;
		}

		public void setItemGrossAmount(BigDecimal itemGrossAmount) {
			ItemGrossAmount = itemGrossAmount;
		}
	}
}
