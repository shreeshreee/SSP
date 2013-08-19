package org.jasig.ssp.web.api;

import java.util.UUID;
import javax.validation.Valid;

import org.jasig.ssp.factory.OAuth2ClientTOFactory;
import org.jasig.ssp.model.ObjectStatus;
import org.jasig.ssp.model.security.oauth2.OAuth2Client;
import org.jasig.ssp.security.permissions.Permission;
import org.jasig.ssp.service.ObjectNotFoundException;
import org.jasig.ssp.service.security.oauth2.OAuth2ClientService;
import org.jasig.ssp.transferobject.OAuth2ClientTO;
import org.jasig.ssp.transferobject.PagedResponse;
import org.jasig.ssp.util.sort.PagingWrapper;
import org.jasig.ssp.util.sort.SortingAndPaging;
import org.jasig.ssp.web.api.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/1/oauth2/client")
public class OAuth2ClientController extends AbstractBaseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(OAuth2ClientController.class);

	@Autowired
	private transient OAuth2ClientService service;

	@Autowired
	private transient OAuth2ClientTOFactory factory;

	// We do not support paging because it would be too difficult to get right
	// so long as we eager-load GrantedAuthorities
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize(Permission.SECURITY_API_KEY_READ)
	public @ResponseBody
	PagedResponse<OAuth2ClientTO> getAll(
			final @RequestParam(required = false) ObjectStatus status,
			final @RequestParam(required = false) String sort,
			final @RequestParam(required = false) String sortDirection) {
		// Run getAll
		final PagingWrapper<OAuth2Client> clients = service.getAll(SortingAndPaging
				.createForSingleSortWithPaging(status, 0, -1, sort, sortDirection,
						null));

		return new PagedResponse<OAuth2ClientTO>(true, clients.getResults(),
				factory.asTOList(clients.getRows()));
	}

	@PreAuthorize(Permission.SECURITY_API_KEY_WRITE)
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	OAuth2ClientTO create(@Valid @RequestBody final OAuth2ClientTO obj)
			throws ObjectNotFoundException, ValidationException {

		if (obj.getId() != null) {
			throw new ValidationException(
					"It is invalid to send an entity with an ID to the create method. Did you mean to use the save method instead?");
		}

		OAuth2Client model = service.create(obj);
		return model == null ? null : factory.from(model);
	}

	@PreAuthorize(Permission.SECURITY_API_KEY_WRITE)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	OAuth2ClientTO save(@PathVariable final UUID id,
						@Valid @RequestBody final OAuth2ClientTO obj)
			throws ValidationException, ObjectNotFoundException {
		if (id == null) {
			throw new ValidationException(
					"You submitted without an id to the save method.  Did you mean to create?");
		}

		if (obj.getId() == null) {
			obj.setId(id);
		}
		OAuth2Client model = service.save(obj);
		return model == null ? null : factory.from(model);
	}

	@Override
	protected Logger getLogger() {
		return LOGGER;
	}
}