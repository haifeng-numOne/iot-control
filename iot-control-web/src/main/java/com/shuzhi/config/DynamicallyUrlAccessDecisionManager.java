package com.shuzhi.config;


import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;

import java.util.Collection;
import java.util.List;

/**
 * @author zgk
 * @description
 * @date 2019-07-04 13:07
 */
public class DynamicallyUrlAccessDecisionManager extends AbstractAccessDecisionManager {

    DynamicallyUrlAccessDecisionManager(List<AccessDecisionVoter<?>> decisionVoters) {
        super(decisionVoters);
    }

    @Override
    public void decide(org.springframework.security.core.Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws org.springframework.security.access.AccessDeniedException, InsufficientAuthenticationException {
        int deny = 0;

        for (AccessDecisionVoter voter : getDecisionVoters()) {
            @SuppressWarnings("unchecked") int result = voter.vote(authentication, object, configAttributes);
            if (logger.isDebugEnabled()) {
                logger.debug("Voter: " + voter + ", returned: " + result);
            }

            switch (result) {
                case AccessDecisionVoter.ACCESS_GRANTED:
                    return;

                case AccessDecisionVoter.ACCESS_DENIED:
                    deny++;

                    break;

                default:
                    break;
            }
        }

        if (deny > 0) {
            throw new org.springframework.security.access.AccessDeniedException(messages.getMessage(
                    "AbstractAccessDecisionManager.accessDenied", "Access is denied"));
        }

        // To get this far, every AccessDecisionVoter abstained
        checkAllowIfAllAbstainDecisions();
    }
}
