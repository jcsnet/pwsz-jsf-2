package pl.itcrowd.jug.utils;


import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import java.util.logging.Logger;


public class PhaseListener implements javax.faces.event.PhaseListener{

    private static final Logger LOGGER = Logger.getLogger(PhaseListener.class.getCanonicalName());

    private RequestCounter requestCounter;

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        ExpressionFactory expressionFactory =
                FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
        ValueExpression valueExpression = expressionFactory.createValueExpression(elContext, "#{requestCounter}", RequestCounter.class);
        this.requestCounter = (RequestCounter) valueExpression.getValue(elContext);

        if(phaseEvent.getPhaseId()==PhaseId.RESTORE_VIEW)
        {
            LOGGER.info("Request count:" + requestCounter.getRequestCount());
        }
        LOGGER.info("BEFORE:" + phaseEvent.getPhaseId());
    }

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        LOGGER.info("AFTER:" + phaseEvent.getPhaseId());
        if (phaseEvent.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            LOGGER.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

}
