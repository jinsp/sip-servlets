/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.as8.deployment;

import javax.servlet.sip.TimerService;

import org.jboss.as.ee.component.InjectionSource;
import org.jboss.as.ee.component.deployers.EEResourceReferenceProcessor;
import org.jboss.as.server.deployment.DeploymentUnit;
import org.jboss.as.server.deployment.DeploymentUnitProcessingException;

/**
 * Processes {@link javax.annotation.Resource @Resource} and {@link javax.annotation.Resources @Resources} annotations
 * for a {@link javax.servlet.sip.TimerService} type resource
 * <p/>
 *
 * @author Jaikiran Pai
 * @author josemrecio@gmail.com
 *
 * This class is based on the contents of org.mobicents.as7.deployment package from jboss-as7-mobicents project, re-implemented for jboss as8 (wildfly) by:
 * @author kakonyi.istvan@alerant.hu
 *
 */
public final class SipTimerServiceResourceProcessor implements EEResourceReferenceProcessor {

    DeploymentUnit sipDeploymentUnit;

    SipTimerServiceResourceProcessor(DeploymentUnit du) {
        super();
        sipDeploymentUnit = du;
    }

    @Override
    public String getResourceReferenceType() {
        return TimerService.class.getName();
    }

    @Override
    public InjectionSource getResourceReferenceBindingSource() throws DeploymentUnitProcessingException {
        return new SipTimerServiceInjectionSource(sipDeploymentUnit);
    }

}
