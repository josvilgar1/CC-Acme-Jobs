/*
 * CustomCommand.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.components;

import acme.framework.components.Command;

public enum CustomCommand implements Command {

	LIST_BEST, LIST_ALL_ACTIVE, LIST_MINE, LIST_APLICATE, LIST_HAS_AUDITRECORD, LIST_NOT_HAS_AUDITRECORD,

	SHOW_BY_JOB, LIST_BY_JOB, SHOW_BY_APPLICATION, SHOW_BY_AUDITRECORD, LIST_JOB

}
