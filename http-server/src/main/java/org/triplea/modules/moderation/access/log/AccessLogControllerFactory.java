package org.triplea.modules.moderation.access.log;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.Jdbi;
import org.triplea.db.dao.access.log.AccessLogDao;

/** Factory class, instantiates {@code AccessLogControllerFactory}. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccessLogControllerFactory {

  public static AccessLogController buildController(final Jdbi jdbi) {
    return AccessLogController.builder()
        .accessLogService(
            AccessLogService.builder().accessLogDao(jdbi.onDemand(AccessLogDao.class)).build())
        .build();
  }
}